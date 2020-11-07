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
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private  lateinit var viewModel :DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater, R.layout.fragment_detail, container, false)
       viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)


        binding.viewModel=viewModel
        binding.lifecycleOwner = this

        binding.apply {
            shoeDetail?.name = shoeName.text.toString()
            shoeDetail?.company = companyName.text.toString()
            shoeDetail?.size = shoeSize.text.toString()
            shoeDetail?.description = shoeDescription.text.toString()
            invalidateAll()

        }

         binding.lifecycleOwner = this

        binding.cancel.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_detailFragment_to_collectionFragment))

        viewModel.navigateToShoeCollection.observe(viewLifecycleOwner,  Observer {
            shoe->
            shoe.let {
                this.findNavController().navigate(
                        DetailFragmentDirections.actionDetailFragmentToCollectionFragment(shoe))
                viewModel.doneNavigating()
            }
        })

        return binding.root
    }


}