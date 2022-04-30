package com.miage.odoru.projet.odorucompetitioncompositeservice.services;

import com.miage.odoru.projet.odorucompetitioncompositeservice.repositories.CompetitionUtilisateurRepository;
import com.miage.odoru.projet.odorucompetitioncompositeservice.repositories.CompetitionUtilisateurRepositoryImpl;
import com.miage.odoru.projet.odorucompetitioncompositeservice.transientobj.CompetitionParticipantTransient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service qui s'occupe de la gestion des compétitions avec leur détail
 */
@Service
public class CompetitionUtilisateurServiceImpl implements CompetitionUtilisateurService {

    @Autowired
    CompetitionUtilisateurRepository competitionUtilisateurRepository;

    /**
     * Obtenir toutes les compétitions avec des détails
     * @return
     */
    @Override
    public Iterable<CompetitionParticipantTransient> obtenirCompetitionDetail() {
        return this.competitionUtilisateurRepository.getAllCompetitionDetail();
    }

    /**
     * Obtenir toutes les compétitions avec des détails, selon le niveau
     * @param idNiveau
     * @return
     */
    @Override
    public Iterable<CompetitionParticipantTransient> obtenirCompetitionDetailSelonNiveau(int idNiveau) {
        return this.competitionUtilisateurRepository.getAllCompetitionsDetailByIdNiveau(idNiveau);
    }

    /**
     * Obtenir toutes les compétitions avec des détails, selon un id d'enseignant de la competition
     * @param idEnseignant
     * @return
     */
    @Override
    public Iterable<CompetitionParticipantTransient> obtenirCompetitionDetailEnseignant(int idEnseignant) {
        return this.competitionUtilisateurRepository.getAllCompetitionDetailByIdEnseignant(idEnseignant);
    }

    /**
     * Obtenir toutes les compétitions avec des détails, selon un id de participant de la competition
     * @param idParticipant
     * @return
     */
    @Override
    public Iterable<CompetitionParticipantTransient> obtenirCompetitionDetailParticipant(int idParticipant) {
        return this.competitionUtilisateurRepository.getAllCompetitionDetailByIdParticipant(idParticipant);
    }
}
