package Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bhumika.softuser_week6.R
import com.bumptech.glide.Glide
import FRagment.ViewFragment
import model.Students

class StudentAdapter(
    var listStudent: ArrayList<Students>,
    var context: ViewFragment
): RecyclerView.Adapter<StudentAdapter.AdapterViewHolder>() {
    class AdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var Name: TextView
        var Age: TextView
        var Address: TextView
        var Gender: TextView
        var Delete: ImageView
        var Uploadimg: ImageView

        init {
            Name = view.findViewById(R.id.name)
            Age = view.findViewById(R.id.age)
            Address = view.findViewById(R.id.address)
            Gender = view.findViewById(R.id.gender)
            Delete = view.findViewById(R.id.delete)
            Uploadimg = view.findViewById(R.id.circleview)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.persona, parent, false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val student = listStudent[position]

        holder.Name.text = student.Name
        holder.Address.text = student.Age.toString()
        holder.Age.text = student.Address
        holder.Gender.text = student.Gender
        Glide.with(
            holder.itemView.context
        ).load(
            student.Image
        ).into(holder.Uploadimg)
        holder.Delete.setOnClickListener {
            listStudent.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return model.listStudent.size
    }
}