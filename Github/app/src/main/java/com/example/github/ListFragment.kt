package com.example.github

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.example.github.viewmodel.ListViewModel
import com.example.github.viewmodel.ListViewModelFactory
import java.util.*


class ListFragment : Fragment() {

    private val viewModel : ListViewModel by activityViewModels{
        ListViewModelFactory((requireActivity().application as MyApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.repoList.observe(viewLifecycleOwner){
            val textView = view.findViewById<TextView>(R.id.repo_list_text)
            textView.text = it.toString()
        }
    }

}