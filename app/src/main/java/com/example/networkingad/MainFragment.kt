package com.example.networkingad


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.networkingad.databinding.FragmentMainBinding
import androidx.lifecycle.Observer
//https://docs.google.com/document/d/1--XYiO1mEI2J7Am1qC9e9dV6R6kWbuPdPT0xjPnzafA/edit

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel:BookViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        viewModel.response.observe(viewLifecycleOwner,Observer{bookList->
            val mAdapter = BookAdapter(bookList)
            binding.recyclerView.adapter = mAdapter
        })

        viewModel.getBooks()

        return binding.root
    }
    override fun onDestroyView(){
        super.onDestroyView()
        _binding=null
    }

}