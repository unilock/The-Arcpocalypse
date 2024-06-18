package arathain.arcpocalypse.client;

import arathain.arcpocalypse.ArcpocalypseComponents;
import arathain.arcpocalypse.ArcpocalypseNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import org.quiltmc.qsl.networking.api.PacketByteBufs;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;

import static arathain.arcpocalypse.ArcpocalypseNetworking.S2C_BURENYA_PACKET;

public class NecoArcNoiseClientCode {
    public static void packetProxy(PlayerEntity player, int lastAttackedTicks) {
        PacketByteBuf buf = PacketByteBufs.create();
        new ArcpocalypseNetworking.ArcSoundEmitterPacket(player.getUuid(), player.getPos(), (player.getAttacking() != null || player.getAttacker() != null || lastAttackedTicks < 100), player.getComponent(ArcpocalypseComponents.ARC_COMPONENT).getNecoType().toString().toLowerCase()).write(buf);
        ClientPlayNetworking.send(S2C_BURENYA_PACKET, buf);
    }
}
