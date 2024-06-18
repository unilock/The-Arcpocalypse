package arathain.arcpocalypse.common;

import net.minecraft.item.Item;

public class NecoItem extends Item {
	public final NekoArcComponent.TypeNeco neco;

	public NecoItem(Settings settings, NekoArcComponent.TypeNeco neco) {
		super(settings);
		this.neco = neco;
	}
}
