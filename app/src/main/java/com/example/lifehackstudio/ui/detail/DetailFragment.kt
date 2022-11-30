package com.example.lifehackstudio.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lifehackstudio.databinding.FragmentDetailCompanyBinding
import com.example.lifehackstudio.domain.model.data.DataCompanyListItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    companion object {
        const val ARGS_KEY = "ARGS_KEY"

        fun newInstance(dataCompany: DataCompanyListItem?) = DetailFragment().apply {
            arguments = Bundle()
            arguments?.putParcelable(ARGS_KEY, dataCompany)
        }
    }

    private var _binding: FragmentDetailCompanyBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailCompanyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initIncomingEvents()
    }


    private fun initViews() {
        detailArguments()
        viewModel.onShowCompany(detailArguments()?.id)
//        binding.tvId.text = detailArguments()?.id
        binding.tvName.text = detailArguments()?.name
    }

    private fun detailArguments(): DataCompanyListItem? {
        return arguments?.getParcelable(ARGS_KEY)
    }

    private fun initIncomingEvents() {
        Toast.makeText(requireActivity(), "initIncomingEvents() DETAIL", Toast.LENGTH_SHORT).show()
        viewModel.repos.observe(viewLifecycleOwner) {
            binding.tvDescription.text = it.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}