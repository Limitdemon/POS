package com.example.pos
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.FileProvider.getUriForFile
import com.example.pos.R
import java.io.File
class SettingActivity : AppCompatActivity() {

    private var imgUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val photo = registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->

            if (isSuccess) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Reminder Message")
                builder.setMessage("Picture Upload Successful")

                builder.setPositiveButton("yes") { dialog, which ->
                    Toast.makeText(applicationContext, android.R.string.yes, Toast.LENGTH_SHORT).show()

                    val linearLayout = findViewById(R.id.Photolayout) as LinearLayout
                    val factor: Float = linearLayout.context.resources.displayMetrics.density
                    val width = (linearLayout.width * factor * 0.75)
                    val height = (linearLayout.height * factor * 0.75)
                    val imgView = ImageView(this)

                    imgView.layoutParams = LinearLayout.LayoutParams(width.toInt(), height.toInt())
                    imgView.setImageURI(imgUri)
                    linearLayout?.addView(imgView)
                }
                builder.show()
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Reminded Message")
                builder.setMessage("Upload Picture Failed")

                builder.setPositiveButton("yes") { dialog, which ->
                    Toast.makeText(applicationContext, android.R.string.yes, Toast.LENGTH_SHORT).show()
                }
                builder.show()
            }
        }

        val btnUpload = findViewById(R.id.Takeaphotobtn) as Button

        btnUpload.setOnClickListener {

            val Pathimage: File = File(getExternalFilesDir(null), "my_images")
            Pathimage.mkdirs()
            val newFile = File(Pathimage, "img_" + System.currentTimeMillis() + ".jpg")
            imgUri = getUriForFile(this@SettingActivity, "com.example.pos.fileprovider", newFile)
            photo.launch(imgUri)
        }

        val contactt = findViewById<Button>(R.id.Contactbtn)

        contactt.setOnClickListener {
            Toast.makeText(
                this,
                "ContactNumber",
                Toast.LENGTH_SHORT
            ).show()


            val intent = Intent(this, Contact::class.java)
            startActivity(intent)

        }

    }
}