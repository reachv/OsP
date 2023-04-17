package com.example.osproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.osproject.Adapters.addFriendsAdapter
import com.parse.Parse
import com.parse.ParseQuery
import com.parse.ParseUser
import org.w3c.dom.Text
import kotlin.collections.Map as Map

class AddFriend : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_friend)
        //Declarations
        var fullUser = HashMap<String, ParseUser>()
        var users = HashMap<String, ParseUser>()
        //TODO bind xlm views
        var input : EditText = findViewById()
        var rv : RecyclerView = findViewById()
        var removeList = ArrayList<String>()
        var adapter : addFriendsAdapter





        //Sends Query to backend for friends list
        var parseQuery : ParseQuery<ParseUser> = ParseUser.getQuery()
        parseQuery.findInBackground { objects, e ->
            if(e != null){
                Log.e("FriendsFragment", "Query Exception: " + e)
                return@findInBackground
            }
            for(i in objects){
                //Skips current user to not display
                if(i.objectId == ParseUser.getCurrentUser().objectId)continue
                //Full user list
                fullUser.put(i.objectId, i)
                //Adapter List
                users.put(i.objectId, i)
            }
        }

        adapter = addFriendsAdapter()


        input.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString().isEmpty()){
                    users = HashMap(fullUser)
                    adapter.notifyDataSetChanged()
                }
                for(i in fullUser){
                    //Iterates through users, matching string
                    if(!i.value.username.contains(s.toString()))removeList.add(i.value.objectId.toString())
                }
                for(i in removeList){
                    if(users.containsKey(i)){
                        users.remove(i)
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })


        rv.adapter = adapter

    }
}