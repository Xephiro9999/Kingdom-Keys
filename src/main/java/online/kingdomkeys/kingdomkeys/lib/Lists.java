package online.kingdomkeys.kingdomkeys.lib;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import online.kingdomkeys.kingdomkeys.item.ModItems;

import java.util.ArrayList;
import java.util.List;

import static online.kingdomkeys.kingdomkeys.item.ModItems.*;

public class Lists {

    public static List<String> keybladeRecipes = new ArrayList<String>();
    public static List<String> itemRecipes = new ArrayList<String>();

    public static List<Item> Xemnas = new ArrayList<Item>();
    public static List<Item> Xigbar = new ArrayList<Item>();
    public static List<Item> Xaldin = new ArrayList<Item>();
    public static List<Item> Vexen = new ArrayList<Item>();
    public static List<Item> Lexaeus = new ArrayList<Item>();
    public static List<Item> Zexion = new ArrayList<Item>();
    public static List<Item> Saix = new ArrayList<Item>();
    public static List<Item> Axel = new ArrayList<Item>();
    public static List<Item> Demyx = new ArrayList<Item>();
    public static List<Item> Luxord = new ArrayList<Item>();
    public static List<Item> Marluxia = new ArrayList<Item>();
    public static List<Item> Larxene = new ArrayList<Item>();
    public static List<Item> Roxas = new ArrayList<>();

    public static List<Item> getListForMember(Utils.OrgMember member) {
        switch (member) {
            case AXEL: return Axel;
            case DEMYX: return Demyx;
            case LARXENE: return Larxene;
            case LEXAEUS: return Lexaeus;
            case LUXORD: return Luxord;
            case MARLUXIA: return Marluxia;
            case ROXAS: return Roxas;
            case SAIX: return Saix;
            case VEXEN: return Vexen;
            case XALDIN: return Xaldin;
            case XEMNAS: return Xemnas;
            case XIGBAR: return Xigbar;
            case ZEXION: return Zexion;
            case NONE: return null;
        }
        return null;
    }

    public static void init () {

        //Xemnas
     /*   Xemnas.add(malice.get());
        Xemnas.add(sanction.get());
        Xemnas.add(overlord.get());
        Xemnas.add(veneration.get());
        Xemnas.add(autocracy.get());
        Xemnas.add(conquest.get());
        Xemnas.add(terminus.get());
        Xemnas.add(judgement.get());
        Xemnas.add(discipline.get());
        Xemnas.add(aristocracy.get());
        Xemnas.add(superiority.get());
        Xemnas.add(aggression.get());
        Xemnas.add(fury.get());
        Xemnas.add(despair.get());
        Xemnas.add(triumph.get());
        Xemnas.add(ruination.get());
        Xemnas.add(domination.get());
        Xemnas.add(annihilation.get());
        Xemnas.add(tyrant.get());
        Xemnas.add(magnificence.get());
        Xemnas.add(infinity.get());
        Xemnas.add(interdiction.get());
        Xemnas.add(roundFan.get());
        Xemnas.add(absolute.get());

        //Xigbar
        Xigbar.add(standalone.get());
        Xigbar.add(killerbee.get());
        Xigbar.add(stingray.get());
        Xigbar.add(counterweight.get());
        Xigbar.add(precision.get());
        Xigbar.add(dualHead.get());
        Xigbar.add(bahamut.get());
        Xigbar.add(gullwing.get());
        Xigbar.add(blueFrame.get());
        Xigbar.add(starShell.get());
        Xigbar.add(sunrise.get());
        Xigbar.add(ignition.get());
        Xigbar.add(armstrong.get());
        Xigbar.add(hardBoiledHeat.get());
        Xigbar.add(diabloEye.get());
        Xigbar.add(doubleTap.get());
        Xigbar.add(stardust.get());
        Xigbar.add(energyMuzzle.get());
        Xigbar.add(crimeAndPunishment.get());
        Xigbar.add(cupidsArrow.get());
        Xigbar.add(finalWeapon.get());
        Xigbar.add(sharpshooter.get());
        Xigbar.add(dryer.get());
        Xigbar.add(trumpet.get());

        //Xaldin
        Xaldin.add(zephyr.get());
        Xaldin.add(moonglade.get());
        Xaldin.add(aer.get());
        Xaldin.add(nescience.get());
        Xaldin.add(brume.get());
        Xaldin.add(asura.get());
        Xaldin.add(crux.get());
        Xaldin.add(paladin.get());
        Xaldin.add(fellking.get());
        Xaldin.add(nightcloud.get());
        Xaldin.add(shimmer.get());
        Xaldin.add(vortex.get());
        Xaldin.add(scission.get());
        Xaldin.add(heavenfall.get());
        Xaldin.add(aether.get());
        Xaldin.add(mazzaroth.get());
        Xaldin.add(hegemon.get());
        Xaldin.add(foxfire.get());
        Xaldin.add(yaksha.get());
        Xaldin.add(cynosura.get());
        Xaldin.add(dragonreign.get());
        Xaldin.add(lindworm.get());
        Xaldin.add(broom.get());
        Xaldin.add(wyvern.get());

        //Vexen
        Vexen.add(testerZero.get());
        Vexen.add(productOne.get());
        Vexen.add(deepFreeze.get());
        Vexen.add(cryoliteShield.get());
        Vexen.add(falseTheory.get());
        Vexen.add(glacier.get());
        Vexen.add(absoluteZero.get());
        Vexen.add(gunz.get());
        Vexen.add(mindel.get());
        Vexen.add(snowslide.get());
        Vexen.add(iceberg.get());
        Vexen.add(inquisition.get());
        Vexen.add(scrutiny.get());
        Vexen.add(empiricism.get());
        Vexen.add(edification.get());
        Vexen.add(contrivance.get());
        Vexen.add(wurm.get());
        Vexen.add(subzero.get());
        Vexen.add(coldBlood.get());
        Vexen.add(diamondShield.get());
        Vexen.add(aegis.get());
        Vexen.add(frozenPride.get());
        Vexen.add(potLid.get());
        Vexen.add(snowman.get());

        //Lexaeus
        Lexaeus.add(reticence.get());
        Lexaeus.add(goliath.get());
        Lexaeus.add(copperRed.get());
        Lexaeus.add(daybreak.get());
        Lexaeus.add(colossus.get());
        Lexaeus.add(ursaMajor.get());
        Lexaeus.add(megacosm.get());
        Lexaeus.add(terrene.get());
        Lexaeus.add(fuligin.get());
        Lexaeus.add(hardWinter.get());
        Lexaeus.add(firefly.get());
        Lexaeus.add(harbinger.get());
        Lexaeus.add(redwood.get());
        Lexaeus.add(sequoia.get());
        Lexaeus.add(ironBlack.get());
        Lexaeus.add(earthshine.get());
        Lexaeus.add(octiron.get());
        Lexaeus.add(hyperion.get());
        Lexaeus.add(clarity.get());
        Lexaeus.add(oneThousandAndOneNights.get());
        Lexaeus.add(cardinalVirtue.get());
        Lexaeus.add(skysplitter.get());
        Lexaeus.add(bleepBloopBop.get());
        Lexaeus.add(monolith.get());

        //Zexion
        Zexion.add(blackPrimer.get());
        Zexion.add(whiteTome.get());
        Zexion.add(illicitResearch.get());
        Zexion.add(buriedSecrets.get());
        Zexion.add(arcaneCompendium.get());
        Zexion.add(dissentersNotes.get());
        Zexion.add(nefariousCodex.get());
        Zexion.add(mysticAlbum.get());
        Zexion.add(cursedManual.get());
        Zexion.add(tabooText.get());
        Zexion.add(eldritchEsoterica.get());
        Zexion.add(freakishBestiary.get());
        Zexion.add(madmansVita.get());
        Zexion.add(untitledWritings.get());
        Zexion.add(abandonedDogma.get());
        Zexion.add(atlasOfOmens.get());
        Zexion.add(revoltingScrapbook.get());
        Zexion.add(lostHeterodoxy.get());
        Zexion.add(otherworldlyTales.get());
        Zexion.add(indescribableLore.get());
        Zexion.add(radicalTreatise.get());
        Zexion.add(bookOfRetribution.get());
        Zexion.add(midnightSnack.get());
        Zexion.add(dearDiary.get());

        //Saix
        Saix.add(newMoon.get());
        Saix.add(werewolf.get());
        Saix.add(artemis.get());
        Saix.add(luminary.get());
        Saix.add(selene.get());
        Saix.add(moonrise.get());
        Saix.add(astrologia.get());
        Saix.add(crater.get());
        Saix.add(lunarPhase.get());
        Saix.add(crescent.get());
        Saix.add(gibbous.get());
        Saix.add(berserker.get());
        Saix.add(twilight.get());
        Saix.add(queenOfTheNight.get());
        Saix.add(balsamicMoon.get());
        Saix.add(orbit.get());
        Saix.add(lightYear.get());
        Saix.add(kingOfTheNight.get());
        Saix.add(moonset.get());
        Saix.add(horoscope.get());
        Saix.add(dichotomy.get());
        Saix.add(lunatic.get());
        Saix.add(justDesserts.get());
        Saix.add(bunnymoon.get());

        //Axel
        Axel.add(ashes.get());
        Axel.add(doldrums.get());
        Axel.add(delayedAction.get());
        Axel.add(diveBombers.get());
        Axel.add(combustion.get());
        Axel.add(moulinRouge.get());
        Axel.add(blazeOfGlory.get());
        Axel.add(prometheus.get());
        Axel.add(ifrit.get());
        Axel.add(magmaOcean.get());
        Axel.add(volcanics.get());
        Axel.add(inferno.get());
        Axel.add(sizzlingEdge.get());
        Axel.add(corona.get());
        Axel.add(ferrisWheel.get());
        Axel.add(burnout.get());
        Axel.add(omegaTrinity.get());
        Axel.add(outbreak.get());
        Axel.add(doubleEdge.get());
        Axel.add(wildfire.get());
        Axel.add(prominence.get());
        Axel.add(eternalFlames.get());
        Axel.add(pizzaCut.get());
        Axel.add(conformers.get());

        //Demyx
        Demyx.add(basicModel.get());
        Demyx.add(tuneUp.get());
        Demyx.add(quartet.get());
        Demyx.add(quintet.get());
        Demyx.add(overture.get());
        Demyx.add(oldHand.get());
        Demyx.add(daCapo.get());
        Demyx.add(powerChord.get());
        Demyx.add(fermata.get());
        Demyx.add(interlude.get());
        Demyx.add(serenade.get());
        Demyx.add(songbird.get());
        Demyx.add(riseToFame.get());
        Demyx.add(rockStar.get());
        Demyx.add(eightFinger.get());
        Demyx.add(concerto.get());
        Demyx.add(harmonics.get());
        Demyx.add(millionBucks.get());
        Demyx.add(fortissimo.get());
        Demyx.add(upToEleven.get());
        Demyx.add(sanctuary.get());
        Demyx.add(arpeggio.get());
        Demyx.add(princeOfAwesome.get());
        Demyx.add(afterSchool.get());

        //Luxord
        Luxord.add(theFool.get());
        Luxord.add(theMagician.get());
        Luxord.add(theStar.get());
        Luxord.add(theMoon.get());
        Luxord.add(justice.get());
        Luxord.add(theHierophant.get());
        Luxord.add(theWorld.get());
        Luxord.add(temperance.get());
        Luxord.add(theHighPriestess.get());
        Luxord.add(theTower.get());
        Luxord.add(theHangedMan.get());
        Luxord.add(death.get());
        Luxord.add(theHermit.get());
        Luxord.add(strength.get());
        Luxord.add(theLovers.get());
        Luxord.add(theChariot.get());
        Luxord.add(theSun.get());
        Luxord.add(theDevil.get());
        Luxord.add(theEmpress.get());
        Luxord.add(theEmperor.get());
        Luxord.add(theJoker.get());
        Luxord.add(fairGame.get());
        Luxord.add(finestFantasy13.get());
        Luxord.add(highRollersSecret.get());

        //Marluxia
        Marluxia.add(fickleErica.get());
        Marluxia.add(jiltedAnemone.get());
        Marluxia.add(proudAmaryllis.get());
        Marluxia.add(madSafflower.get());
        Marluxia.add(poorMelissa.get());
        Marluxia.add(tragicAllium.get());
        Marluxia.add(mournfulCineria.get());
        Marluxia.add(pseudoSilene.get());
        Marluxia.add(faithlessDigitalis.get());
        Marluxia.add(grimMuscari.get());
        Marluxia.add(docileVallota.get());
        Marluxia.add(quietBelladonna.get());
        Marluxia.add(partingIpheion.get());
        Marluxia.add(loftyGerbera.get());
        Marluxia.add(gallantAchillea.get());
        Marluxia.add(noblePeony.get());
        Marluxia.add(fearsomeAnise.get());
        Marluxia.add(vindictiveThistle.get());
        Marluxia.add(fairHelianthus.get());
        Marluxia.add(solemnMagnolia.get());
        Marluxia.add(hallowedLotus.get());
        Marluxia.add(gracefulDahlia.get());
        Marluxia.add(stirringLadle.get());
        Marluxia.add(daintyBellflowers.get());

        //Larxene
        Larxene.add(trancheuse.get());
        Larxene.add(orage.get());
        Larxene.add(tourbillon.get());
        Larxene.add(tempete.get());
        Larxene.add(carmin.get());
        Larxene.add(meteore.get());
        Larxene.add(etoile.get());
        Larxene.add(irregulier.get());
        Larxene.add(dissonance.get());
        Larxene.add(eruption.get());
        Larxene.add(soleilCouchant.get());
        Larxene.add(indigo.get());
        Larxene.add(vague.get());
        Larxene.add(deluge.get());
        Larxene.add(rafale.get());
        Larxene.add(typhon.get());
        Larxene.add(extirpeur.get());
        Larxene.add(croixDuSud.get());
        Larxene.add(lumineuse.get());
        Larxene.add(clairDeLune.get());
        Larxene.add(volDeNuit.get());
        Larxene.add(foudre.get());
        Larxene.add(demoiselle.get());
        Larxene.add(ampoule.get());*/

        Roxas.add(kingdomKey.get());
        Roxas.add(missingAche.get());
        Roxas.add(ominousBlight.get());
        Roxas.add(abaddonPlasma.get());
        Roxas.add(painOfSolitude.get());
        Roxas.add(signOfInnocence.get());
        Roxas.add(crownOfGuilt.get());
        Roxas.add(abyssalTide.get());
        Roxas.add(leviathan.get());
        Roxas.add(trueLightsFlight.get());
        Roxas.add(rejectionOfFate.get());
        Roxas.add(midnightRoar.get());
        Roxas.add(glimpseOfDarkness.get());
        Roxas.add(totalEclipse.get());
        Roxas.add(silentDirge.get());
        Roxas.add(lunarEclipse.get());
        Roxas.add(darkerThanDark.get());
        Roxas.add(astralBlast.get());
        Roxas.add(maverickFlare.get());
        Roxas.add(twilightBlaze.get());
        Roxas.add(omegaWeapon.get());
        Roxas.add(oathkeeper.get());
        Roxas.add(twoBecomeOne.get());
        Roxas.add(oblivion.get());
        Roxas.add(umbrella.get());
        Roxas.add(aubade.get());
        Roxas.add(woodenStick.get());

        //Keyblades
        keybladeRecipes.add(abaddonPlasma.get().getTranslationKey());
        keybladeRecipes.add(abyssalTide.get().getTranslationKey());
        keybladeRecipes.add(allForOne.get().getTranslationKey());
        keybladeRecipes.add(invisKeyblade.get().getTranslationKey());
        keybladeRecipes.add(astralBlast.get().getTranslationKey());
        keybladeRecipes.add(aubade.get().getTranslationKey());
        keybladeRecipes.add(bondOfFlame.get().getTranslationKey());
        keybladeRecipes.add(brightcrest.get().getTranslationKey());
        keybladeRecipes.add(chaosRipper.get().getTranslationKey());
        keybladeRecipes.add(circleOfLife.get().getTranslationKey());
        keybladeRecipes.add(counterpoint.get().getTranslationKey());
        keybladeRecipes.add(crabclaw.get().getTranslationKey());
        keybladeRecipes.add(crownOfGuilt.get().getTranslationKey());
        keybladeRecipes.add(darkerThanDark.get().getTranslationKey());
        keybladeRecipes.add(darkgnaw.get().getTranslationKey());
        keybladeRecipes.add(decisivePumpkin.get().getTranslationKey());
        keybladeRecipes.add(destinysEmbrace.get().getTranslationKey());
        keybladeRecipes.add(diamondDust.get().getTranslationKey());
        keybladeRecipes.add(divewing.get().getTranslationKey());
        keybladeRecipes.add(divineRose.get().getTranslationKey());
        //recipes.add(dreamShield.get().getTranslationKey());
        //recipes.add(dreamStaff.get().getTranslationKey());
        //recipes.add(dreamSword.get().getTranslationKey());
        keybladeRecipes.add(dualDisc.get().getTranslationKey());
        keybladeRecipes.add(earthshaker.get().getTranslationKey());
        keybladeRecipes.add(endOfPain.get().getTranslationKey());
        keybladeRecipes.add(endsOfTheEarth.get().getTranslationKey());
        keybladeRecipes.add(fairyHarp.get().getTranslationKey());
        keybladeRecipes.add(fairyStars.get().getTranslationKey());
        keybladeRecipes.add(fatalCrest.get().getTranslationKey());
        keybladeRecipes.add(fenrir.get().getTranslationKey());
        keybladeRecipes.add(ferrisGear.get().getTranslationKey());
        keybladeRecipes.add(followTheWind.get().getTranslationKey());
        keybladeRecipes.add(frolicFlame.get().getTranslationKey());
        keybladeRecipes.add(glimpseOfDarkness.get().getTranslationKey());
        keybladeRecipes.add(guardianBell.get().getTranslationKey());
        keybladeRecipes.add(guardianSoul.get().getTranslationKey());
        keybladeRecipes.add(gullWing.get().getTranslationKey());
        keybladeRecipes.add(herosCrest.get().getTranslationKey());
        keybladeRecipes.add(hiddenDragon.get().getTranslationKey());
        keybladeRecipes.add(hyperdrive.get().getTranslationKey());
        keybladeRecipes.add(incompleteKiblade.get().getTranslationKey());
        keybladeRecipes.add(jungleKing.get().getTranslationKey());
        keybladeRecipes.add(keybladeOfPeoplesHearts.get().getTranslationKey());
        keybladeRecipes.add(kiblade.get().getTranslationKey());
        keybladeRecipes.add(kingdomKey.get().getTranslationKey());
        keybladeRecipes.add(kingdomKeyD.get().getTranslationKey());
        keybladeRecipes.add(knockoutPunch.get().getTranslationKey());
        keybladeRecipes.add(ladyLuck.get().getTranslationKey());
        keybladeRecipes.add(flameLiberator.get().getTranslationKey());
        keybladeRecipes.add(gulasKeyblade.get().getTranslationKey());
        keybladeRecipes.add(leviathan.get().getTranslationKey());
        keybladeRecipes.add(lionheart.get().getTranslationKey());
        keybladeRecipes.add(lostMemory.get().getTranslationKey());
        keybladeRecipes.add(lunarEclipse.get().getTranslationKey());
        keybladeRecipes.add(markOfAHero.get().getTranslationKey());
        keybladeRecipes.add(mastersDefender.get().getTranslationKey());
        keybladeRecipes.add(maverickFlare.get().getTranslationKey());
        keybladeRecipes.add(metalChocobo.get().getTranslationKey());
        keybladeRecipes.add(midnightRoar.get().getTranslationKey());
        keybladeRecipes.add(mirageSplit.get().getTranslationKey());
        keybladeRecipes.add(missingAche.get().getTranslationKey());
        keybladeRecipes.add(monochrome.get().getTranslationKey());
        keybladeRecipes.add(moogleOGlory.get().getTranslationKey());
        keybladeRecipes.add(mysteriousAbyss.get().getTranslationKey());
        keybladeRecipes.add(nightmaresEnd.get().getTranslationKey());
        keybladeRecipes.add(nightmaresEndAndMirageSplit.get().getTranslationKey());
        keybladeRecipes.add(noName.get().getTranslationKey());
        keybladeRecipes.add(noNameBBS.get().getTranslationKey());
        keybladeRecipes.add(oathkeeper.get().getTranslationKey());
        keybladeRecipes.add(oblivion.get().getTranslationKey());
        keybladeRecipes.add(oceansRage.get().getTranslationKey());
        keybladeRecipes.add(olympia.get().getTranslationKey());
        keybladeRecipes.add(omegaWeapon.get().getTranslationKey());
        keybladeRecipes.add(ominousBlight.get().getTranslationKey());
        keybladeRecipes.add(oneWingedAngel.get().getTranslationKey());
        keybladeRecipes.add(painOfSolitude.get().getTranslationKey());
        keybladeRecipes.add(photonDebugger.get().getTranslationKey());
        keybladeRecipes.add(pixiePetal.get().getTranslationKey());
        keybladeRecipes.add(pumpkinhead.get().getTranslationKey());
        keybladeRecipes.add(rainfell.get().getTranslationKey());
        keybladeRecipes.add(rejectionOfFate.get().getTranslationKey());
        keybladeRecipes.add(royalRadiance.get().getTranslationKey());
        keybladeRecipes.add(rumblingRose.get().getTranslationKey());
        keybladeRecipes.add(shootingStar.get().getTranslationKey());
        keybladeRecipes.add(signOfInnocence.get().getTranslationKey());
        keybladeRecipes.add(silentDirge.get().getTranslationKey());
        keybladeRecipes.add(skullNoise.get().getTranslationKey());
        keybladeRecipes.add(sleepingLion.get().getTranslationKey());
        keybladeRecipes.add(soulEater.get().getTranslationKey());
        keybladeRecipes.add(spellbinder.get().getTranslationKey());
        keybladeRecipes.add(starlight.get().getTranslationKey());
        keybladeRecipes.add(starSeeker.get().getTranslationKey());
        keybladeRecipes.add(stormfall.get().getTranslationKey());
        keybladeRecipes.add(strokeOfMidnight.get().getTranslationKey());
        keybladeRecipes.add(sweetDreams.get().getTranslationKey());
        keybladeRecipes.add(sweetMemories.get().getTranslationKey());
        keybladeRecipes.add(sweetstack.get().getTranslationKey());
        keybladeRecipes.add(threeWishes.get().getTranslationKey());
        keybladeRecipes.add(totalEclipse.get().getTranslationKey());
        keybladeRecipes.add(treasureTrove.get().getTranslationKey());
        keybladeRecipes.add(trueLightsFlight.get().getTranslationKey());
        keybladeRecipes.add(twilightBlaze.get().getTranslationKey());
        keybladeRecipes.add(twoBecomeOne.get().getTranslationKey());
        keybladeRecipes.add(ultimaWeaponBBS.get().getTranslationKey());
        keybladeRecipes.add(ultimaWeaponDDD.get().getTranslationKey());
        keybladeRecipes.add(ultimaWeaponKH1.get().getTranslationKey());
        keybladeRecipes.add(ultimaWeaponKH2.get().getTranslationKey());
        keybladeRecipes.add(ultimaWeaponKH3.get().getTranslationKey());
        keybladeRecipes.add(umbrella.get().getTranslationKey());
        keybladeRecipes.add(unbound.get().getTranslationKey());
        keybladeRecipes.add(irasKeyblade.get().getTranslationKey());
        keybladeRecipes.add(acedsKeyblade.get().getTranslationKey());
        keybladeRecipes.add(victoryLine.get().getTranslationKey());
        keybladeRecipes.add(voidGear.get().getTranslationKey());
        keybladeRecipes.add(avasKeyblade.get().getTranslationKey());
        keybladeRecipes.add(waytotheDawn.get().getTranslationKey());
        keybladeRecipes.add(waywardWind.get().getTranslationKey());
        keybladeRecipes.add(winnersProof.get().getTranslationKey());
        keybladeRecipes.add(wishingLamp.get().getTranslationKey());
        keybladeRecipes.add(wishingStar.get().getTranslationKey());
        keybladeRecipes.add(youngXehanortsKeyblade.get().getTranslationKey());
        keybladeRecipes.add(zeroOne.get().getTranslationKey());
        
        //Items
        itemRecipes.add(mythril_crystal.get().getTranslationKey());
        itemRecipes.add(mythril_gem.get().getTranslationKey());
        itemRecipes.add(mythril_stone.get().getTranslationKey());
        itemRecipes.add(mythril_shard.get().getTranslationKey());
        
       /* TODO for(String keyblade : MainConfig.items.bannedKeyblades) {
        	if(recipes.indexOf("item."+keyblade) >= 0)
        		recipes.remove(recipes.indexOf("item."+keyblade));
        }*/
    }

}
