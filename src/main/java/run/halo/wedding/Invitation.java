package run.halo.wedding;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import run.halo.app.extension.AbstractExtension;
import run.halo.app.extension.GVK;

/**
 * 邀请函实体，自定义模型
 */
@Data
@EqualsAndHashCode(callSuper = true)
@GVK(kind = "Invitation", group = "invitation.plugin.halo.run",
    version = "v1alpha1", singular = "invitation", plural = "invitations")
public class Invitation extends AbstractExtension {

    @Schema(requiredMode = REQUIRED)
    private WeddingInvitationSpec spec;

    @Data
    public static class WeddingInvitationSpec {

        /**
         * 新郎
         */
        @Schema(requiredMode = REQUIRED, minLength = 1)
        private String groom;

        /**
         * 新娘
         */
        @Schema(requiredMode = REQUIRED, minLength = 1)
        private String bride;

        /**
         * 婚礼日期
         */
        @Schema(required = true)
        private Date weddingDate;

        /**
         * 婚礼地点
         */
        @Schema(required = true)
        private String weddingAddress;

        /**
         * 请柬内容
         */
        @Schema(required = true)
        private String invitationContent;
    }
}
