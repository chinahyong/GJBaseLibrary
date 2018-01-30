package tv.guojiang.baselib.image;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import tv.guojiang.baselib.BaseLibConfig;
import tv.guojiang.baselib.image.factory.GlideFactory;
import tv.guojiang.baselib.image.factory.ImageFactory;

/**
 * @author Elvis
 */

public class ImageDirector {

    private static ImageDirector imageDirector;
    private static ImageFactory mFactory = BaseLibConfig.mConfigBuilder.imageFactory;

    private ImageDirector() {
        if (mFactory == null) {
            mFactory = new GlideFactory();
        }
    }

    public static ImageDirector getInstance() {
        if (imageDirector == null) {
            synchronized (ImageDirector.class) {
                if (imageDirector == null) {
                    imageDirector = new ImageDirector();
                }
            }
        }
        return imageDirector;
    }

    public ImageBuilder imageBuilder(Context context) {
        ImageBuilder imageBuilder = new ImageBuilder(context);
        return imageBuilder;
    }

    /**
     * 加载图片的方式仅限于 ImageBuilder直接调用，屏蔽掉其他类调用。在此跟builder防御同包下面
     */
    ImageDirector loadImage(ImageBuilder imageBuilder) {
        if (imageBuilder != null) {
            mFactory.loadImage(imageBuilder.getContext(), imageBuilder.mImageEntity);
        }
        return this;
    }

    Object loadImageSyn(ImageBuilder imageBuilder) throws Exception {
        if (imageBuilder != null) {
            return mFactory.loadImageSyn(imageBuilder.getContext(), imageBuilder.mImageEntity);
        }
        return null;
    }

    public void clear(Context context, @NonNull ImageView imageView) {
        mFactory.clear(context, imageView);
    }

    public void clearMemory(Context context) {
        mFactory.clearMemory(context);
    }

}
