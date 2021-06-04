package com.moviewapp.trailorapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.moviewapp.trailorapp.data.network.RemoteDataSource
import com.moviewapp.trailorapp.data.repository.BaseRepository
import javax.inject.Inject

abstract class BaseFragment<VM : ViewModel, B : ViewBinding , R : BaseRepository> : Fragment(){

    protected lateinit var binding : B
    protected lateinit var viewModel: VM
   // protected lateinit var preferences: UserPreferences
    protected val remoteDataSource = RemoteDataSource()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
       // preferences = UserPreferences(requireContext())
        binding = getFragmentBinding(inflater,container)
        val factory = ViewModelFactory(getFrgamentRepository())
        viewModel = ViewModelProvider(this,factory).get(getViewModel())
        return binding.root
    }

    abstract fun getViewModel() : Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater,container: ViewGroup?) : B

    abstract fun  getFrgamentRepository() : R
}


