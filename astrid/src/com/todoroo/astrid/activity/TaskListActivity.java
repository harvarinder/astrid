package com.todoroo.astrid.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.timsu.astrid.R;
import com.todoroo.astrid.fragment.FilterListFragment;
import com.todoroo.astrid.fragment.TaskListFragment;

/**
 * Primary activity for the Bente application. Shows a list of upcoming
 * tasks and a user's coaches.
 *
 * @author Tim Su <tim@todoroo.com>
 *
 */
public class TaskListActivity extends Activity {
    protected TaskListFragment tasklistFragment = null;

    public TaskListFragment getTasklistFragment() {
        return tasklistFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.task_list_fragment);
        tasklistFragment = (TaskListFragment)getFragmentManager().findFragmentById(R.id.tasklist_fragment);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SEARCH)) {
            // forward the searchrequest to the filterfragment
            FilterListFragment flFragment = (FilterListFragment)getFragmentManager().findFragmentById(R.id.filterlist_fragment);
            if (flFragment != null && flFragment.isInLayout())
                flFragment.onNewIntent(intent);
        } else {
            if (tasklistFragment == null)
                tasklistFragment = (TaskListFragment)getFragmentManager().findFragmentById(R.id.tasklist_fragment);

            if (tasklistFragment != null) {
                tasklistFragment.onNewIntent(intent);
            }
        }
    }

}
