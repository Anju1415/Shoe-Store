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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ActivityNavigatorExtras
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentCollectionBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_collection.*
import kotlinx.android.synthetic.main.fragment_collection.view.*

class CollectionFragment : Fragment() {

    private lateinit var binding : FragmentCollectionBinding
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentCollectionBinding>(inflater, R.layout.fragment_collection, container, false)

       // val application = requireNotNull(this.activity).application
         //   val arguments = CollectionFragmentArgs.fromBundle(arguments!!)
           // Toast.makeText(context, "{${arguments.shoeItem?.name}}", Toast.LENGTH_LONG).show()
           // val viewModelFactory = CollectionViewModelFactory(arguments.shoeItem!!, application)
           /*model.shoesString.observe(viewLifecycleOwner, Observer {
               binding.shoeDetails.text = it
           })*/

        binding.lifecycleOwner = this

        binding.fab.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_collectionFragment_to_detailFragment)
        )
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = DetailViewModelFactory(application)
        val model=ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)
        model.shoesString.observe(viewLifecycleOwner, Observer {
            str->
                binding.shoeDetails.text= str
        })
        binding.viewModel=model
    }

}