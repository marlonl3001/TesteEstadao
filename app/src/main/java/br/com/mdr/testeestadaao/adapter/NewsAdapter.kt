package br.com.mdr.testeestadaao.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mdr.testeestadaao.databinding.NewsItemBinding
import br.com.mdr.testeestadaao.model.business.News
import br.com.mdr.testeestadaao.util.safeHeritage

class NewsAdapter(
    private val onItemClickListener: ((news: News) -> Unit)
) : RecyclerView.Adapter<NewsAdapter.BooksViewHolder>(), IAdapterItemsContract {
    private val newsList: ArrayList<News> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): BooksViewHolder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksViewHolder(binding, onItemClickListener)
    }

    override fun getItemCount() = newsList.count()

    override fun onBindViewHolder(viewHolder: BooksViewHolder, position: Int) {
        viewHolder.bindView(newsList[position])
    }

    override fun replaceItens(list: List<Any>) {
        addValues(list.safeHeritage())
    }

    private fun addValues(news: List<News>) {
        newsList.clear()
        newsList.addAll(news)
        notifyDataSetChanged()
    }

    class BooksViewHolder(
        private val binding: NewsItemBinding,
        private val onItemClickListener: ((news: News) -> Unit)
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(news: News) {
            binding.apply {
                this.news = news
                root.setOnClickListener {
                    onItemClickListener.invoke(news)
                }
            }
        }
    }
}
