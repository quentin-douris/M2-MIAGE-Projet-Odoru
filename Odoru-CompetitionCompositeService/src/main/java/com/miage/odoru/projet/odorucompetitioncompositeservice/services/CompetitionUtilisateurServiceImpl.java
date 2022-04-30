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

    @Override
    public Iterable<CompetitionParticipantTransient> obtenirCompetitionDetail() {
        return this.competitionUtilisateurRepository.getAllCompetitionDetail();
    }

    @Override
    public Iterable<CompetitionParticipantTransient> obtenirCompetitionDetailSelonNiveau(int idNiveau) {
        return this.competitionUtilisateurRepository.getAllCompetitionsDetailByIdNiveau(idNiveau);
    }
}
