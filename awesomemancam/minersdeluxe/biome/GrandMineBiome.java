package awesomemancam.minersdeluxe.biome;

import net.minecraft.entity.passive.EntityBat;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import awesomemancam.minersdeluxe.MinersDeluxe;
import awesomemancam.minersdeluxe.mob.EntityAwesomemancam;
import awesomemancam.minersdeluxe.mob.EntityCaveSnake;

public class GrandMineBiome extends BiomeGenBase
{
    public GrandMineBiome(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityBat.class, 200, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCaveSnake.class, 50, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityAwesomemancam.class, 1, 1, 1));
        
        this.waterColorMultiplier = 0x134d26;
        
        this.setBiomeName("Grand Mine Cave");
    }
}