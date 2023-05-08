package run.halo.wedding;

import org.pf4j.PluginWrapper;
import org.springframework.stereotype.Component;
import run.halo.app.extension.Scheme;
import run.halo.app.extension.SchemeManager;
import run.halo.app.plugin.BasePlugin;

@Component
public class WeddingInvitationPlugin extends BasePlugin {

    private final SchemeManager schemeManager;

    public WeddingInvitationPlugin(PluginWrapper wrapper, SchemeManager schemeManager) {
        super(wrapper);
        this.schemeManager = schemeManager;
    }

    @Override
    public void start() {
        // 插件启动时注册自定义模型
        schemeManager.register(Invitation.class);
        System.out.println("Hello world 插件启动了!");
    }

    @Override
    public void stop() {
        // 插件停用时取消注册自定义模型
        Scheme invitationScheme = schemeManager.get(Invitation.class);
        schemeManager.unregister(invitationScheme);
        System.out.println("Hello world 被停止!");
    }
}
