package com.udacity.shoestore


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe

class DetailFragment : Fragment() {

    lateinit var viewModel: DetailViewModel
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater, R.layout.fragment_detail, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(DetailViewModel::class.java)

        binding.lifecycleOwner = this
        binding.save.setOnClickListener {

            binding.shoeDetail = Shoe(
                    binding.shoeName.text.toString(),
                    binding.shoeSize.text.toString(),
                    binding.companyName.text.toString(),
                    binding.shoeDescription.text.toString()
            )

            val s = binding.shoeDetail
            viewModel.saveCurrentDetail(s)
            view?.findNavController()?.navigate(R.id.action_detailFragment_to_collectionFragment)
        }


        binding.cancel.setOnClickListener {

            view?.findNavController()?.navigate(R.id.action_detailFragment_to_collectionFragment)
        }

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.addShoesDetail)
        return binding.root
    }

}