package com.udacity.shoestore


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe

class DetailFragment : Fragment()  {

    private  lateinit var viewModel :DetailViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater, R.layout.fragment_detail, container, false)

        val application = requireNotNull(this.activity).application

        val viewModelFactory = DetailViewModelFactory(application)


        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)
        binding.lifecycleOwner = this

        binding.save.setOnClickListener{

            /*binding.apply {
                shoeDetail?.name = shoeName.text.toString()
                shoeDetail?.company = companyName.text.toString()
                shoeDetail?.size = shoeSize.text.toString()
                shoeDetail?.description = shoeDescription.text.toString()
                //   invalidateAll()

            }*/

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

        binding.cancel.setOnClickListener{

            view?.findNavController()?.navigate(R.id.action_detailFragment_to_collectionFragment)
        }

        return binding.root
    }

}