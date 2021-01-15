package FRagment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import com.bhumika.softuser_week6.R
import model.Students
import model.adapter
import model.listStudent

class UploadFragment : Fragment(){

    private lateinit var etname: EditText
    private lateinit var etage: EditText
    private lateinit var etadd: EditText
    private lateinit var btnsubmit: Button
    private lateinit var rgbtn: RadioGroup
    private lateinit var Gender: String
    private lateinit var Image: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_upload, container, false)
        etname = view.findViewById(R.id.etname)
        etage = view.findViewById(R.id.etage)
        rgbtn = view.findViewById(R.id.rgbtn)
        etadd = view.findViewById(R.id.etadd)
        btnsubmit = view.findViewById(R.id.btnsubmit)
        btnsubmit.setOnClickListener {
            if (upload()) {
                radiogroup()
                Toast.makeText(context,"The user is added.", Toast.LENGTH_SHORT).show()
                clear()
            }
        }
        return view
    }

    private fun upload(): Boolean {
        val Name = etname.text.toString()
        val Age = etage.text.toString()
        val Gender = rgbtn.isSelected.toString()
        val Address = etadd.text.toString()
        if (Name.isBlank() || Age.isBlank() || Gender.isBlank() || Address.isBlank()) {
            etname.error = "Full Name must not be empty."
            etname.requestFocus()
            etadd.error = "Address must not be empty."
            etadd.requestFocus()
            etage.error = "Age must not be empty."
            etage.requestFocus()
        }
        return true
    }

    private fun clear(){
        etname.setText("")
        etage.setText("")
        etadd.setText("")
        rgbtn.clearCheck()

    }

    private fun radiogroup() {
        val id = rgbtn.checkedRadioButtonId
        when(id){
            R.id.rbmale -> Gender = "Male"
            R.id.rbfemale -> Gender = "Female"
            R.id.rbothers -> Gender = "Other"
        }
        if (Gender == "Male"){
            Image = "https://cdn.onlinewebfonts.com/svg/img_504768.png"
        }
        if(Gender == "Female"){
            Image = "https://www.pngitem.com/pimgs/m/110-1104775_user-woman-business-woman-png-icon-transparent-png.png"
        }
        if (Gender == "Other")
        {
            Image = "https://img.icons8.com/cotton/2x/Gender.png"
        }
        val Name = etname.text.toString()
        val Age = etage.text.toString().toInt()
        val Address = etadd.text.toString()
        listStudent.add(Students(Name, Age, "$Address","$Gender","$Image"))
        adapter.notifyDataSetChanged()


    }
}