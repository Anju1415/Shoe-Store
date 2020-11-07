package com.udacity.shoestore

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ActivityNavigatorExtras
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentCollectionBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_collection.*
import kotlinx.android.synthetic.main.fragment_collection.view.*

class CollectionFragment : Fragment()  {

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
       val binding = DataBindingUtil.inflate<FragmentCollectionBinding>(inflater, R.layout.fragment_collection, container, false)

        val application = requireNotNull(this.activity).application

        val viewModelFactory = DetailViewModelFactory(application)

        binding.lifecycleOwner = this

        val model=ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        binding.shoeDetails.text = model.shoesString.toString()

        binding.fab.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_collectionFragment_to_detailFragment)
        )
        return binding.root
    }


}