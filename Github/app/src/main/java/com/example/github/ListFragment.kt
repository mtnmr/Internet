package com.example.github

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.github.adapter.GithubListAdapter
import com.example.github.databinding.FragmentListBinding
import com.example.github.viewmodel.ListViewModel
import com.example.github.viewmodel.ListViewModelFactory
import java.util.*


class ListFragment : Fragment() {

    private lateinit var binding : FragmentListBinding

    private val viewModel : ListViewModel by activityViewModels{
        ListViewModelFactory((requireActivity().application as MyApplication).repository, requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listAdapter = GithubListAdapter{
            viewModel.onRepoClick(it)
            val action = ListFragmentDirections.actionListFragmentToDetailFragment()
            view.findNavController().navigate(action)
        }

        binding.repoListRecyclerView.adapter = listAdapter

//        viewModel.repoList.observe(viewLifecycleOwner){ items ->
//            items.let {
//                listAdapter.submitList(it)
//            }
//        }

//        viewModel.repoList.observe(viewLifecycleOwner){
//            val textView = view.findViewById<TextView>(R.id.repo_list_text)
//            textView.text = it[0].name
//        }
    }

}