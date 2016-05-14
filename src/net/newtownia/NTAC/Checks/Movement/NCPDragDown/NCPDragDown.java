package net.newtownia.NTAC.Checks.Movement.NCPDragDown;

import net.newtownia.NTAC.Checks.Movement.AbstractMovementCheck;
import net.newtownia.NTAC.Checks.Movement.MovementBase;
import net.newtownia.NTAC.NTAC;
import net.newtownia.NTAC.Utils.NCPUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Created by Vinc0682 on 13.05.2016.
 */
public class NCPDragDown extends AbstractMovementCheck
{
    private NCPDragDownHook hook;

    public NCPDragDown(NTAC pl, MovementBase movementBase)
    {
        super(pl, movementBase, "NCP-Drag-Down");
        loadConfig();
    }

    @Override
    public void onPlayerMove(PlayerMoveEvent event) {

    }

    @Override
    public void loadConfig()
    {
        if (hook == null)
        {
            if (isEnabled() && NCPUtils.hasNoCheatPlus())
            {
                hook = new NCPDragDownHook(pl, this);
                hook.hook();
            }
            else
            {
                Bukkit.getLogger().info("NoCheatPlus is required for NCP-Drag-Down!");
            }
        }
        else
        {
            hook.loadConfig();
            hook.hook();
        }
    }
}