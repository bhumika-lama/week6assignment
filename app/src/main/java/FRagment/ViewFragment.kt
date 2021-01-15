package FRagment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bhumika.softuser_week6.R
import model.adapter

class ViewFragment : Fragment() {
    private lateinit var View: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_view, container, false)
        View= view.findViewById(R.id.recyclerview)

        View.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL,false)
        View.adapter = adapter
        return view
    }
}