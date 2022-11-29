package com.example.lifehackstudio.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lifehackstudio.R
import com.example.lifehackstudio.databinding.FragmentMainCompanyBinding
import com.example.lifehackstudio.domain.Controller
import com.example.lifehackstudio.ui.detail.DetailFragment
import com.example.lifehackstudio.ui.main.recycler.RecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(){

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainCompanyBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModel()

    private val adapter = RecyclerViewAdapter {
        controller.openSecondFragment(it)
        Toast.makeText(requireActivity(), "clicker ${it.name}", Toast.LENGTH_SHORT).show()
    }

    private val controller by lazy { activity as Controller }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainCompanyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initIncomingEvents()
    }

    private fun initViews() {
        viewModel.onShowList()
        recyclerView()
    }

    private fun recyclerView() {
        binding.recyclerViewCompanyList.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewCompanyList.adapter = adapter
    }

    private fun initIncomingEvents() {
        viewModel.repos.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}