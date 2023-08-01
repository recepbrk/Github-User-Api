package com.example.retrofitlearnproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/*
Adapter Yapısı

class Adapter (parametre tanımlanır):RecyclerView.Adapter<Adapterinİsmi.ViewHolderClassın>{

inner class  class adı (parametre):RecyclerView.ViewHolder(view nesnesi){
}
}


 */


class MyAdapter(var context: Context,var list: List<UsersItem>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    inner class ViewHolder(v:View):RecyclerView.ViewHolder(v){
        var img = v.findViewById<ImageView>(R.id.RV_Image)
        var tvName = v. findViewById<TextView>(R.id.RV_tv)
        var type = v.findViewById<TextView>(R.id.TVtype)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.count()

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(context).load(list[position].avatar_url).into(holder.img)
        holder.tvName.text = list[position].login
        holder.type.text=list[position].type
    }
}