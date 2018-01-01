package f.p.p.myviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import junit.framework.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.TestViewHolder>{
    private List<String> dataList;
    private Context mContext;

    public RecyclerAdapter(List<String> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View convertView = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_view, parent,false);
//        View testView = View.inflate(mContext,R.layout.item_recycler_view, null);
//        View convertView = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, null);
        TestViewHolder viewHolder = new TestViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        holder.content.setText(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class TestViewHolder extends RecyclerView.ViewHolder{
        private TextView content;

        public TestViewHolder(View itemView) {
            super(itemView);
            content = (TextView)itemView.findViewById(R.id.tv_content);
        }
    }
}
