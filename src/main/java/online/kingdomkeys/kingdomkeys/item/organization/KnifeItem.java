package online.kingdomkeys.kingdomkeys.item.organization;

import online.kingdomkeys.kingdomkeys.lib.Utils;

public class KnifeItem extends OrgWeaponItem implements IOrgWeapon {
    @Override
    public Utils.OrgMember getMember() {
        return Utils.OrgMember.LARXENE;
    }

}
