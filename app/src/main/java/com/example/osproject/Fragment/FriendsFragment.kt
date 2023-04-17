package com.example.osproject.Fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.osproject.Adapters.friendsAdapter
import com.example.osproject.AddFriend
import com.example.osproject.GnS.FriendsList
import com.example.osproject.R
import com.parse.ParseQuery
import com.parse.ParseUser


class FriendsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_friends, container, false)
        var recyclerView : RecyclerView = view.findViewById(R.id.friendsRv)
        var add : Button = view.findViewById(R.id.FriendsAdd)
        var friends = ArrayList<ParseUser>()
        lateinit var adapter : friendsAdapter
        var longclick =  friendsAdapter.OnLongClickListener {
            friends.removeAt(it)
            adapter.notifyDataSetChanged()
            Toast.makeText(context, "Successfully Removed", Toast.LENGTH_SHORT).show()
        }

        //ClickListener to add Friends
        add.setOnClickListener {
            var intent = Intent(context, AddFriend::class.java)
            startActivity(intent)
        }



        //Sends Query to backend for friends list
        var parseQuery : ParseQuery<ParseUser> = ParseQuery.getQuery("Friends")
        parseQuery.whereEqualTo("currUser", ParseUser.getCurrentUser().objectId)
        parseQuery.findInBackground { objects, e ->
            if(e != null){
                Log.e("FriendsFragment", "Query Exception: " + e)
                return@findInBackground
            }
            for(i in objects){
                friends.add(i)
            }
        }

        //Creates instance of adapter and binds adapter to recyclerView
        adapter = friendsAdapter(friends, longclick)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        return view

    }
}