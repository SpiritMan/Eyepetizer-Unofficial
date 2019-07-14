package com.yolocc.eyepetizerunofficial

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 切换fragment时会走onResume() -> onDestroy()
 */
class DiscoverFragment : Fragment() {

    companion object {
        private val TAG = "DiscoverFragment"
        fun newInstance() = DiscoverFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.v(TAG, "onCreateView")
        return inflater.inflate(R.layout.discover_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.v(TAG, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
        viewModel = (activity as MainActivity).obtainViewModel()
        viewModel.getCategory()
        // TODO: Use the ViewModel
    }

}
