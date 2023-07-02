package main;

import arc.Events;
import arc.struct.Seq;
import mindustry.Vars;
import mindustry.core.Logic;
import mindustry.game.EventType;
import mindustry.game.SpawnGroup;
import mindustry.io.SaveFileReader;
import mindustry.io.SaveIO;
import mindustry.io.SaveVersion;
import mindustry.mod.Mod;
import rhino.ImporterTopLevel;
import rhino.NativeJavaPackage;

public class Iris extends Mod {

    public static SpawningSystem system = new SpawningSystem();
    @Override
    public void init() {
        super.init();

        Events.on(EventType.Trigger.drawOver.getClass(), e -> Overlay.draw());
        ImporterTopLevel scope = (ImporterTopLevel) Vars.mods.getScripts().scope;

        Seq<String> packages = Seq.with(
                "main"
        );


        packages.each(name -> {
            NativeJavaPackage p = new NativeJavaPackage(name, Vars.mods.mainLoader());

            p.setParentScope(scope);

            scope.importPackage(p);
        });
    }
}