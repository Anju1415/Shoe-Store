package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentCollectionBinding

class CollectionFragment : Fragment()  {

private lateinit var model: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
       val binding = DataBindingUtil.inflate<FragmentCollectionBinding>(inflater, R.layout.fragment_collection, container, false)

        model = ViewModelProvider(this).get(DetailViewModel::class.java)

        binding.lifecycleOwner = this

        model.shoes.observe(viewLifecycleOwner, Observer {
            list ->
          //  Toast.makeText(context,"$list", Toast.LENGTH_LONG).show()
            val adapter = ShoeAdapter(list)
            binding.list.adapter = adapter
        })

        binding.fab.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_collectionFragment_to_detailFragment)
        )
        return binding.root
    }


}