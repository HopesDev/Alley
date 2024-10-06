package me.emmy.alley.game.match.impl;

import me.emmy.alley.arena.Arena;
import me.emmy.alley.kit.Kit;
import me.emmy.alley.game.match.player.GameParticipant;
import me.emmy.alley.game.match.player.impl.MatchGamePlayerImpl;
import me.emmy.alley.queue.Queue;

/**
 * @author Remi
 * @project Alley
 * @date 5/21/2024
 */
public class MatchBedRegularImpl extends MatchRegularImpl {

    /**
     * Constructor for the BedMatchImpl class.
     *
     * @param kit          The kit of the match.
     * @param arena        The arena of the match.
     * @param participantA The first participant.
     * @param participantB The second participant.
     */
    public MatchBedRegularImpl(Queue queue, Kit kit, Arena arena, boolean ranked, GameParticipant<MatchGamePlayerImpl> participantA, GameParticipant<MatchGamePlayerImpl> participantB) {
        super(queue, kit, arena, ranked, participantA, participantB);
    }
}