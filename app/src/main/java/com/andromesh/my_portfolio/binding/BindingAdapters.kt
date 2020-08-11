package com.elifox.legocatalog.binding

import android.annotation.TargetApi
import android.os.Build
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.andromesh.my_portfolio.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText


@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("isGone")
fun bindIsGone(view: FloatingActionButton, isGone: Boolean?) {
    if (isGone == null || isGone) {
        view.hide()
    } else {
        view.show()
    }
}

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view)
    }
}

@BindingAdapter("renderHtml")
fun bindRenderHtml(view: TextView, description: String?) {
    if (description != null) {
        view.text = HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_COMPACT)
        view.movementMethod = LinkMovementMethod.getInstance()
    } else {
        view.text = ""
    }
}

@BindingAdapter("onError")
fun bindOnError(editText: EditText, strOrResId: Any?) {
    if (strOrResId is Int) {
        editText.error = editText.context
                .getString((strOrResId as Int?)!!)
    } else {
        editText.error = strOrResId as String?
    }
}

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@BindingAdapter("onEmailValidationError")
fun bindonEmailValidationError(editText: TextInputEditText, strOrResId: Boolean) {
    if (strOrResId) {
        editText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.valid_input, 0, R.drawable.username_icon, 0)
    } else {
        editText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.invalid_input, 0, R.drawable.username_icon, 0)
    }
}


@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@BindingAdapter("onEmailValidationErrorET")
fun bindonEmailValidationErrorET(editText: EditText, strOrResId: Boolean) {
    if (strOrResId) {
        editText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.valid_input, 0, R.drawable.username_icon, 0)
    } else {
        editText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.invalid_input, 0, R.drawable.username_icon, 0)
    }
}

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@BindingAdapter("onPasswordlValidationError")
fun bindononPasswordlValidationError(editText: TextInputEditText, strOrResId: Boolean) {
    if (strOrResId) {
        editText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.valid_input, 0, 0, 0)
    } else {
        editText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.invalid_input, 0, 0, 0)
    }
}

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@BindingAdapter("onPasswordEmptyError")
fun bindonPasswordEmptyError(editText: EditText, strOrResId: Boolean) {
    if (strOrResId) {
        editText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.valid_input, 0, R.drawable.username_icon, 0)
    } else {
        editText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.invalid_input, 0, R.drawable.username_icon, 0)
    }
}

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@BindingAdapter("onPasswordEmptyErrorTLI")
fun bindonPasswordEmptyErrorTLI(editText: TextInputEditText, strOrResId: Boolean) {
    if (strOrResId) {
        editText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.valid_input, 0, R.drawable.username_icon, 0)
    } else {
        editText.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.invalid_input, 0, R.drawable.username_icon, 0)
    }
}

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
@BindingAdapter("onPasswordEmptyErrorTV")
fun bindonPasswordEmptyErrorTV(textView: TextView, strOrResId: Boolean) {
    if (strOrResId) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.valid_input18dp, 0)
    } else {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.invalid_input_18dp, 0)
    }
}



