import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.MainActivity
import com.example.todo.R
import com.google.android.material.textfield.TextInputEditText


class CustomAdapter(private var dataSet: MutableList<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    // TODO: instead of array of string, make it of map of id to string
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val buttonView: android.widget.Button
        val textView: com.google.android.material.textfield.TextInputEditText

        init {
            // Define click listener for the ViewHolder's View.
            buttonView = view.findViewById(R.id.done_button)
            textView = view.findViewById(R.id.item_text)
        }

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(
        viewHolder: ViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {

        // Get element from your dataset at this position and                                                                                                                                                                                                                                        replace the
        // contents of the view with that element
        viewHolder.textView.setText(dataSet[position])
        viewHolder.textView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                //Toast.makeText(viewHolder.textView.context, viewHolder.textView.text.toString(), Toast.LENGTH_SHORT).show()
                dataSet[viewHolder.adapterPosition] = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        viewHolder.buttonView.setOnClickListener {
            //Toast.makeText(viewHolder.textView.context, viewHolder.textView.text.toString(), Toast.LENGTH_SHORT).show()
            deleteItem(position)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    fun deleteItem(index: Int) {
        dataSet.removeAt(index)
        notifyItemRemoved(index);
        notifyItemRangeChanged(index,dataSet.size);
    }

    fun addItem() {
        dataSet.add("")
        notifyDataSetChanged()
    }

    fun setText(viewHolder: CustomAdapter.ViewHolder) {
        dataSet[viewHolder.adapterPosition] = viewHolder.textView.text.toString()
    }
}
