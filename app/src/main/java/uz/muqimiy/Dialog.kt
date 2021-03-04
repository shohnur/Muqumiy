package uz.muqimiy

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView

class Dialog(context: Context) : AlertDialog(context) {


    init {
        setTitle("Tanlang")
        val view = LayoutInflater.from(context).inflate(R.layout.dialog, null, false)
        setView(view)
        view.findViewById<TextView>(R.id.telegram).setOnClickListener {
            onClickListener?.onTelegram()
            cancel()
        }
        view.findViewById<TextView>(R.id.website).setOnClickListener {
            onClickListener?.onSite()
            cancel()
        }

        setButton(BUTTON_NEGATIVE, "Qaytish") { dialog, _ ->
            dialog.cancel()
        }
        setCancelable(false)
    }

    interface OnClickListener {
        fun onSite()
        fun onTelegram()
    }

    var onClickListener: OnClickListener? = null

}