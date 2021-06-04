package com.moviewapp.trailorapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moviewapp.trailorapp.data.network.GithubApi
import com.moviewapp.trailorapp.data.network.MovieApi
import com.moviewapp.trailorapp.data.network.RepoSearchResult
import com.moviewapp.trailorapp.data.network.Resource
import com.moviewapp.trailorapp.data.repository.GithubRepository
import com.moviewapp.trailorapp.data.repository.MovieRepository
import com.moviewapp.trailorapp.databinding.FragmentItemListBinding
import com.moviewapp.trailorapp.ui.SearchRepositoriesViewModel
import com.moviewapp.trailorapp.ui.base.BaseFragment
import com.moviewapp.trailorapp.utils.handleApiError
import com.moviewapp.trailorapp.utils.visible

class MovirFragment : BaseFragment<MovieViewModel, FragmentItemListBinding, MovieRepository>(){
    private lateinit var myAdpater: MyItemRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressbar.visible(false)
        binding.tvNoDataFound.visible(false)
        val query = savedInstanceState?.getString(LAST_SEARCH_QUERY) ?: DEFAULT_QUERY
        val layoutManager = LinearLayoutManager(requireContext())
        myAdpater = MyItemRecyclerViewAdapter(requireContext())
        binding.rcvMovieList.layoutManager = layoutManager
       // setupScrollListener(layoutManager)
        viewModel.getAllMovie(1)

        binding.rcvMovieList.adapter = myAdpater
        viewModel.allMovieList?.observe(viewLifecycleOwner, Observer {
            Log.e("responseObserve",it.toString())
            when (it) {
                is Resource.Success -> {
                    binding.progressbar.visible(false)
                    it.value.results.let { it1 -> myAdpater.moviewList(it1) }
                }
                is Resource.Loading -> {
                    binding.progressbar.visible(true)
                }
                is Resource.Failure -> {
                    handleApiError(it)
                }
            }
        })


    }

    private fun showEmptyList(show: Boolean) {
        if (show) {
            binding.tvNoDataFound.visible(true)
            binding.rcvMovieList.visible(false)
        } else {
            binding.tvNoDataFound.visible(false)
            binding.rcvMovieList.visible(true)
        }
    }

  /*  private fun setupScrollListener(layoutManager : LinearLayoutManager) {
        binding.rcvMovieList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val totalItemCount = layoutManager.itemCount
                val visibleItemCount = layoutManager.childCount
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
                viewModel.listScrolled(visibleItemCount, lastVisibleItem, totalItemCount)
            }
        })
    }*/
    override fun getViewModel(): Class<MovieViewModel> = MovieViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentItemListBinding.inflate(inflater,container,false)

    override fun getFrgamentRepository(): MovieRepository {
        return MovieRepository(remoteDataSource.buildApi(MovieApi::class.java,requireContext()))
    }
    companion object {
        private const val LAST_SEARCH_QUERY: String = "last_search_query"
        private const val DEFAULT_QUERY = "Android"
    }
}