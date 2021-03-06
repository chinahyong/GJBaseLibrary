package tv.guojiang.network;

import java.io.File;
import java.util.List;
import tv.guojiang.baselib.network.annotation.ContentType;
import tv.guojiang.baselib.network.annotation.Upload;
import tv.guojiang.baselib.network.request.BaseRequest;

/**
 * 文件上传请求
 *
 * @author leo
 */
public class UploadRequest extends BaseRequest {

    public String username;

    public String password;

    @ContentType("image/png")
    @Upload("picture")
    public List<File> file;

}
