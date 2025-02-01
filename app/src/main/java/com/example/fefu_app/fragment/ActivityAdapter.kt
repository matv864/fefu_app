
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fefu_app.EmptyState
import com.example.fefu_app.R
import com.example.fefu_app.fragment.ActivityEntity


class ActivityAdapter(activityList: List<ActivityEntity>, view: View) : RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {
    private val activityList = activityList
    private val view = view

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ActivityViewHolder(view)
    }
    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val activity = activityList[position]
        holder.bind(activity)

    }

    override fun getItemCount(): Int = activityList.size

    inner class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mainTextView: TextView = itemView.findViewById(R.id.item_text)

        fun bind(activity: ActivityEntity) {
            mainTextView.text = activity.text

            itemView.setOnClickListener {
                val intent = Intent(view.context, EmptyState::class.java)
                intent.putExtra("activity_id", activity.id)
                view.context.startActivity(intent)
            }
        }
    }
}