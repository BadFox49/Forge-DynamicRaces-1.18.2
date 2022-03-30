package net.badfox49.dynamic_races.client.model.species;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.badfox49.dynamic_races.client.model.DynamicRacesModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WolfmanModel<T extends LivingEntity> extends HumanoidModel<T> {
        private final ModelPart head;
        private final ModelPart nose;
        private final ModelPart body;
        private final ModelPart tail;
        private final ModelPart leftEar;
        private final ModelPart leftLeg;
        private final ModelPart rightEar;
        private final ModelPart rightLeg;

    public WolfmanModel(ModelPart modelPart) {
        super(modelPart);
        this.hat.visible = false;
        this.head = modelPart.getChild("head");
        this.nose = modelPart.getChild("nose");
        this.body = modelPart.getChild("body");
        this.tail = modelPart.getChild("tail");
        this.leftEar = modelPart.getChild("left_ear");
        this.leftLeg = modelPart.getChild("left_leg");
        this.rightEar = modelPart.getChild("right_ear");
        this.rightLeg = modelPart.getChild("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        // Head
        partDefinition.addOrReplaceChild("head",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // Nose
        partDefinition.addOrReplaceChild("nose",
                CubeListBuilder.create().texOffs(24, 2)
                        .addBox(-2.5F, -4.0F, -7.0F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // Body
        partDefinition.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(16, 16)
                        .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // Tail
        partDefinition.addOrReplaceChild("tail",
                CubeListBuilder.create().texOffs(32, 2)
                        .addBox(-1.5F, 10.0F, 1.0F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // Ears
        partDefinition.addOrReplaceChild("left_ear",
                CubeListBuilder.create().texOffs(54, 32)
                        .addBox(1.0F, -10.0F, 2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_ear",
                CubeListBuilder.create().texOffs(54, 32)
                        .addBox(-4.0F, -10.0F, 2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // Arms
        partDefinition.addOrReplaceChild("left_arm",
                CubeListBuilder.create().texOffs(32, 48)
                        .addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(5.0F, 2.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_arm",
                CubeListBuilder.create().texOffs(40, 16)
                        .addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-5.0F, 2.0F, 0.0F));

        // Legs
        partDefinition.addOrReplaceChild("left_leg",
                CubeListBuilder.create().texOffs(16, 48)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(2.0F, 12.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_leg",
                CubeListBuilder.create().texOffs(0, 16)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-2.0F, 12.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public void renderEars(T pEntity) {
        if (pEntity.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
            this.leftEar.visible = true;
            this.rightEar.visible = true;
        } else {
            this.leftEar.visible = false;
            this.rightEar.visible = false;
        }
    }

    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        super.setupAnim(pEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
        this.leftEar.copyFrom(this.head);
        this.rightEar.copyFrom(this.head);
        this.nose.copyFrom(this.head);
        if (pEntity.isCrouching()) {
            this.tail.z = 1.4F;
            this.tail.y = 1.85F;
        } else {
            this.tail.z = 0.0F;
            this.tail.y = 0.0F;
        }
    }

    @Override
    public void translateToHand(HumanoidArm pSide, PoseStack pPoseStack) {
        ModelPart modelpart = this.getArm(pSide);
        modelpart.translateAndRotate(pPoseStack);
    }
}