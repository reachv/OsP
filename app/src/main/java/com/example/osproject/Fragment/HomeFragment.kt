package com.example.osproject.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.osproject.R

class HomeFragment : Fragment() {

    companion object{
        fun newInstance(): HomeFragment{
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_post, container, false)
        //Variable Declaration
        var friends : Button = view.findViewById(R.id.FriendsAdd)
        var fRV : RecyclerView = view.findViewById(R.id.friendsRv)



        return view
    }

}