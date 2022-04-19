package com.example.github

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.github.databinding.FragmentDetailBinding
import com.example.github.viewmodel.ListViewModel
import com.example.github.viewmodel.ListViewModelFactory


class DetailFragment : Fragment() {

    private lateinit var binding : FragmentDetailBinding

    private val viewModel : ListViewModel by activityViewModels{
        ListViewModelFactory((requireActivity().application as MyApplication).repository, requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.apply {
//            repoName.text = viewModel.repo.value?.name
//            url.text = viewModel.repo.value?.htmlUrl
//            fullName.text = viewModel.repo.value?.fullName
//            description.text = viewModel.repo.value?.description
//            language.text = viewModel.repo.value?.language
//            defaultBranch.text = viewModel.repo.value?.defaultBranch
//            pushedAt.text = viewModel.repo.value?.pushedAt
//            createdAt.text = viewModel.repo.value?.createdAt
//            updatedAt.text = viewModel.repo.value?.updatedAt
//        }
//
//        if (binding.description.text == ""){
//            binding.description.text = getString(R.string.null_message)
//        }
//
//        if (binding.language.text == ""){
//            binding.language.text = getString(R.string.null_message)
//        }
    }
}