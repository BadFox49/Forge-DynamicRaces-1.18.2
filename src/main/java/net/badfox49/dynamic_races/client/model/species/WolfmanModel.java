package net.badfox49.dynamic_races.client.model.species;

import net.badfox49.dynamic_races.client.model.DynamicRacesModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.TamableAnimal;

public class WolfmanModel<T extends TamableAnimal> extends HumanoidModel<T>
    implements DynamicRacesModel {
        private final ModelPart head;
        private final ModelPart nose;
        private final ModelPart body;
        private final ModelPart tail;
        private final ModelPart leftEar;
        private final ModelPart leftHand;
        private final ModelPart leftLeg;
        private final ModelPart rightEar;
        private final ModelPart rightHand;
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
        this.leftHand = modelPart.getChild("left_hand");
        this.rightEar = modelPart.getChild("right_ear");
        this.rightHand = modelPart.getChild("right_hand");
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

        // Hands
        partDefinition.addOrReplaceChild("leftHand",
                CubeListBuilder.create(),
                PartPose.offset(6.0F, 11.0F, 0.0F));
        partDefinition.addOrReplaceChild("rightHand",
                CubeListBuilder.create(),
                PartPose.offset(-6.0F, 11.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float p_102867_, float p_102868_, float p_102869_, float p_102870_, float p_102871_) {
        if (entity.isInSittingPose()) {
            this.head.setPos(0.0F, 8.0F, 0.0F);
            this.nose.setPos(0.0F, 8.0F, 0.0F);
            this.body.setPos(0.0F, 8.0F, 0.0F);
            this.tail.setPos(0.0F, 8.0F, 1.0F);
            this.leftEar.setPos(0.0F, 8.0F, 0.0F);
            this.rightEar.setPos(0.0F, 8.0F, 0.0F);
            this.leftArm.setPos(5.0F, 10.0F, 0.0F);
            this.rightArm.setPos(-5.0F, 10.0F, 0.0F);
            this.leftLeg.setPos(-1.9F, 22.0F, 0.0F);
            this.leftLeg.xRot = -1.6F;
            this.leftLeg.yRot = 0.1F;
            this.rightLeg.setPos(2.1F, 22.0F, 0.0F);
            this.rightLeg.xRot = -1.6F;
            this.rightLeg.yRot = -0.1F;
        } else {
            super.setupAnim(entity, p_102867_, p_102868_, p_102869_, p_102870_, p_102871_);
        }
    }
}