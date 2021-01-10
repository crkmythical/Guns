package cn.stylefeng.guns.modular.index.controller;

import cn.stylefeng.guns.modular.index.service.IndexService;
import cn.stylefeng.roses.kernel.auth.api.context.LoginContext;
import cn.stylefeng.roses.kernel.resource.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.resource.api.annotation.GetResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.annotation.Resource;

/**
 * 首页相关的界面渲染
 *
 * @author fengshuonan
 * @date 2020/12/27 16:23
 */
@Controller
@Slf4j
@ApiResource(name = "首页相关的界面渲染")
public class IndexViewController {

    @Resource
    private IndexService indexService;

    /**
     * 首页界面
     *
     * @author fengshuonan
     * @date 2020/12/13 17:19
     */
    @GetResource(name = "首页界面", path = "/", requiredLogin = false, requiredPermission = false, viewFlag = true)
    public String indexView(Model model) {

        // 当前用户已经登录，跳转到首页
        if (LoginContext.me().hasLogin()) {
            model.addAllAttributes(indexService.createIndexRenderAttributes());
            return "/index.html";
        }

        // 当前用户没有登录，跳转到登录页面
        return "/login.html";
    }

    /**
     * 个人中心界面
     *
     * @author fengshuonan
     * @date 2020/12/29 21:53
     */
    @GetResource(name = "个人中心界面", path = "/view/personal", requiredLogin = false)
    public String personal(Model model) {
        model.addAllAttributes(indexService.createPersonInfoRenderAttributes());
        return "/modular/index/personal_info.html";
    }

    /**
     * 锁屏界面
     *
     * @author fengshuonan
     * @date 2020/12/29 21:34
     */
    @GetResource(name = "锁屏界面", path = "/view/lock", requiredPermission = false)
    public String lock() {
        return "/modular/index/lock_screen.html";
    }

    /**
     * 主题切换界面
     *
     * @author fengshuonan
     * @date 2020/12/29 21:42
     */
    @GetResource(name = "主题切换界面", path = "/view/theme", requiredPermission = false)
    public String theme() {
        return "/modular/index/theme.html";
    }

    /**
     * 修改密码界面
     *
     * @author fengshuonan
     * @date 2020/12/29 21:42
     */
    @GetResource(name = "修改密码界面", path = "/view/changePassword", requiredPermission = false)
    public String changePassword() {
        return "/modular/index/change_password.html";
    }


    /**
     * 系统消息界面
     *
     * @author liuhanqing
     * @date 2021/1/10 17:42
     */
    @GetResource(name = "系统消息界面", path = "/view/message", requiredPermission = false)
    public String message() {
        return "/modular/index/message.html";
    }
}
