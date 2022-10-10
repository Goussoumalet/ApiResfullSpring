package com.blog.api.restfull.metier;

import com.blog.api.restfull.dto.TArticleDto;

import java.util.List;

public interface TArticleMetier {
    List<TArticleDto> list(); //methode permettant de retourner la list de tous les articles
    TArticleDto find(Long id); // methode permettant de retourner un article selon son id
    TArticleDto save(TArticleDto dto); //methode permettant de sauvegarder les articles
    TArticleDto update(TArticleDto dto); // methode permettant de faire la mise à jour des articles
    boolean delete(Long id);             // methode permettant de supprimer un article selon son id

}
