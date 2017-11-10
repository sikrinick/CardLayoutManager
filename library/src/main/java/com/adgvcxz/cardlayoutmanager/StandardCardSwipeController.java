package com.adgvcxz.cardlayoutmanager;

import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.LinearLayout;

import java.util.Random;

import static com.adgvcxz.cardlayoutmanager.CardLayoutManager.DIRECTION_END;
import static com.adgvcxz.cardlayoutmanager.CardLayoutManager.DIRECTION_START;

/**
 * Write to @sikri on Slack, if you have any questions.
 */

public class StandardCardSwipeController extends BaseCardSwipeController {

    public StandardCardSwipeController(int orientation) {
        super(orientation);
    }

    @Override
    public CardSwipeModel generateAnimOutModel(View view, int position) {
        return generateAnimModel(DIRECTION_END);
    }

    @Override
    public CardSwipeModel generateAnimInModel(int position) {
        return generateAnimModel(DIRECTION_START);
    }

    @Override
    public int[] getDownPosition() {
        return new int[]{-1, -1};
    }

    protected CardSwipeModel generateAnimModel(int direction) {
        Random random = new Random();
        if (mOrientation == LinearLayout.HORIZONTAL) {
            int x = (int) (mMaxWidth / Math.cos(12)) * (direction == DIRECTION_END ? 1 : -1);
            int y = 7;
            return new CardSwipeModel(x, y, random.nextInt(Math.abs(x) / 3) + Math.abs(x) / 3, new AnticipateOvershootInterpolator(), direction);
        } else {
            int y = (int) (mMaxHeight / Math.cos(12)) * (direction == DIRECTION_END ? 1 : -1);
            int x = random.nextInt(mMaxWidth / 4) * (random.nextBoolean() ? 1 : -1);
            return new CardSwipeModel(x, y, random.nextInt(Math.abs(y) / 4) + Math.abs(y) / 4, new AnticipateOvershootInterpolator(), direction);
        }
    }
}
