package me.emmy.alley.match.impl;

import me.emmy.alley.arena.Arena;
import me.emmy.alley.kit.Kit;
import me.emmy.alley.match.player.GameParticipant;
import me.emmy.alley.match.player.impl.MatchGamePlayerImpl;
import me.emmy.alley.queue.Queue;

public class MatchLivesRegularImpl extends MatchRegularImpl {

    /**
     * Constructor for the LivesMatchImpl class.
     *
     * @param kit          The kit of the match.
     * @param arena        The arena of the match.
     * @param participantA The first participant.
     * @param participantB The second participant.
     */
    public MatchLivesRegularImpl(Queue queue, Kit kit, Arena arena, GameParticipant<MatchGamePlayerImpl> participantA, GameParticipant<MatchGamePlayerImpl> participantB) {
        super(queue, kit, arena, participantA, participantB);
    }
}