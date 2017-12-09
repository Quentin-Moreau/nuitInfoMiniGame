package com.polytech.nuitinfo.NF;

import com.polytech.nuitinfo.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Howard Alexandre on 16/03/2017.
 */

public class GestionnaireQuestion {
    private ArrayList<Question> Cmpt1Serie1=new ArrayList<Question>();
    private ArrayList<Question> Cmpt1Serie2=new ArrayList<Question>();
    private ArrayList<Question> Cmpt1Serie3=new ArrayList<Question>();
    /*private ArrayList<Question> Cmpt2Serie1=new ArrayList<Question>();
    private ArrayList<Question> Cmpt2Serie2=new ArrayList<Question>();
    private ArrayList<Question> Cmpt2Serie3=new ArrayList<Question>();*/

    //Hash map pour garder la reponse donné pour chaque question fausse
    private HashMap<Question, Reponse> erreurs = new HashMap<Question, Reponse>();

    //Singleton
    private static GestionnaireQuestion gestionnaireQuestion = new GestionnaireQuestion();

    private GestionnaireQuestion(){
        this.construireSeriesQuestion();
    }

    /*
    * Function made by Tua Mathieu and Munier Rémy
     */
    private void construireSeriesQuestion(){
        //construction de nos exercices c'est long...
        Reponse reponse1_1_1 = new Reponse("50 km/h","C'est juqte ce qu'il faut pour bien réagir");
        this.Cmpt1Serie1.add(new Question("Quelle est la vitesse max en agglomeration ?", reponse1_1_1));

        Reponse reponse1_1_2 = new Reponse("Oui","Si t'as pas envie de finir dans le parbrise vaut mieux la mettre");
        this.Cmpt1Serie1.add(new Question("Doit on attacher sa ceinture ?", reponse1_1_2));

        Reponse reponse1_1_3 = new Reponse("L'un mais pas l'autre","Boire et conduire ca fait pas bon ménage");
        this.Cmpt1Serie1.add(new Question("Boire ou conduire ?", reponse1_1_3));

        Reponse reponse1_1_4 = new Reponse("A droite","Surveilles bien ta droite aux intersections");
        this.Cmpt1Serie1.add(new Question("De quel côté est la prio en l'absence de panneau?", reponse1_1_4));

        Reponse reponse1_1_5 = new Reponse("M'arrête","Rouge STOP, vert PASSER");
        this.Cmpt1Serie1.add(new Question("Au feu rouge je...?", reponse1_1_5));

        Reponse reponse1_1_6 = new Reponse("Avant","Mieux vaut prévenir que guérir");
        this.Cmpt1Serie1.add(new Question("Le clignotant avant ou pendant le virage?", reponse1_1_6));

        Reponse reponse1_1_7 = new Reponse("Non","Garde ton calme, les nerveux meurent plus vite");
        this.Cmpt1Serie1.add(new Question("Il t'a fait un queue de poisson tu l'insulte?", reponse1_1_7));

        Reponse reponse1_1_8 = new Reponse("A droite","L'autre sens serait risqué");
        this.Cmpt1Serie1.add(new Question("On roule de quel côté ?", reponse1_1_8));

        Reponse reponse1_1_9 = new Reponse("A gauche","Vous le surprendriez si vous le doubliez par la droite");
        this.Cmpt1Serie1.add(new Question("On double de quel côté ?", reponse1_1_9));

        Reponse reponse1_1_10 = new Reponse("Interdit","Stay focus on the road bro");
        this.Cmpt1Serie1.add(new Question("Le telephone au volant ?", reponse1_1_10));

        Reponse reponse1_2_1 = new Reponse("croisement","Pour etre vu et ne pas aveugler");
        this.Cmpt1Serie2.add(new Question("En croisement j'utilise les feux de...?", reponse1_2_1));

        Reponse reponse1_2_2 = new Reponse("Une technique pour tourner","Faut faire chevaucher nos mains rapidement pour tourner plus");
        this.Cmpt1Serie2.add(new Question("Qu'est ce que le chevauchement ?", reponse1_2_2));

        Reponse reponse1_2_3 = new Reponse("50, voire moins","Prudence est mère de sureté");
        this.Cmpt1Serie2.add(new Question("C'est limité a 50 je roule a combien ?", reponse1_2_3));

        Reponse reponse1_2_4 = new Reponse("2","Un mississipi... deux mississipi");
        this.Cmpt1Serie2.add(new Question("Nombre de secondes d'intervalle de sécurité", reponse1_2_4));

        Reponse reponse1_2_5 = new Reponse("Non","Attention au bloquage dans les pédales");
        this.Cmpt1Serie2.add(new Question("Peux tu porter des tong en conduisant ?", reponse1_2_5));

        Reponse reponse1_2_6 = new Reponse("Non","On entend moins ce qui nous entoure");
        this.Cmpt1Serie2.add(new Question("As tu le droit d'écouter ta musique avec des écouteurs en conduisant", reponse1_2_6));

        Reponse reponse1_2_7 = new Reponse("5/10","Bien voir pour bien conduire");
        this.Cmpt1Serie2.add(new Question("Acuité visuelle minimale a chaque oeil ?", reponse1_2_7));

        Reponse reponse1_2_8 = new Reponse("A droite","On utilise le meme pied pour accélerateur et frein");
        this.Cmpt1Serie2.add(new Question("L'accélerateur est... ?", reponse1_2_8));

        Reponse reponse1_2_9 = new Reponse("Au milieu","On utilise le meme pied pour accélerateur et frein");
        this.Cmpt1Serie2.add(new Question("Le frein est...?", reponse1_2_9));

        Reponse reponse1_2_10 = new Reponse("Appuyer sur l'embrayage","On DEtache le liaison entre les roues et le moteur");
        this.Cmpt1Serie2.add(new Question("Débrayer c'est...?", reponse1_2_10));

        Reponse reponse1_3_1 = new Reponse("Relacher l'embrayage","On EMboite la liaison entre les roues et le moteur");
        this.Cmpt1Serie3.add(new Question("Embrayer c'est...?", reponse1_3_1));

        Reponse reponse1_3_2 = new Reponse("2 heures","Conduire c'est mieux une fois reposé");
        this.Cmpt1Serie3.add(new Question("On fait généralement une pause toutes les... ?", reponse1_3_2));

        Reponse reponse1_3_3 = new Reponse("Zero","Quepouick, quedal");
        this.Cmpt1Serie3.add(new Question("Quelle est la quantité max d'alcool autorisé dans le sang en tant qu'apprenti ?", reponse1_3_3));

        Reponse reponse1_3_4 = new Reponse("50m","Faut prévenir ceux qui arrivent");
        this.Cmpt1Serie3.add(new Question("A quelle distance on met le triangle de signalisation en cas d'accident ?", reponse1_3_4));

        Reponse reponse1_3_5 = new Reponse("A celui qui monte","Le pauvre pour redemarrer c'est difficile");
        this.Cmpt1Serie3.add(new Question("Priorité a qui dans une montée ?", reponse1_3_5));

        Reponse reponse1_3_6 = new Reponse("Oui mais...","C'est toléré mais ne manipule pas ton téléphone en conduisant");
        this.Cmpt1Serie3.add(new Question("Le kit main libre autorisé ?", reponse1_3_6));

        Reponse reponse1_3_7 = new Reponse("ISSOU, non","Mon pote t'arrive meme pas a ouvrir ta portière");
        this.Cmpt1Serie3.add(new Question("Un café après la biture de ce soir ca passe ?", reponse1_3_7));

        Reponse reponse1_3_8 = new Reponse("Non, ce n'est pas un jeu la conduite","C'est du sérieux");
        this.Cmpt1Serie3.add(new Question("Une mamie a 100 point je fonce ?", reponse1_3_8));

        Reponse reponse1_3_9 = new Reponse("2 ans","6points au départ puis 3 par an");
        this.Cmpt1Serie3.add(new Question("Combien d'années avant tes 12 points en fillière AAC ?", reponse1_3_9));

        Reponse reponse1_3_10 = new Reponse("En cas de Brouillard, Neige et/ou Pluie","On te verra mieux ;)");
        this.Cmpt1Serie3.add(new Question("Quand doit on activer ses phares de brouillard avant?", reponse1_3_10));

        /*Reponse reponse2_1_1 = new Reponse("Peindre","Paint signifie Peindre");
        this.Cmpt2Serie1.add(new Question("Que veux dire Paint", reponse2_1_1));

        Reponse reponse2_1_2 = new Reponse("Café","Coffee signifie Café");
        this.Cmpt2Serie1.add(new Question("Que veux dire Coffee", reponse2_1_2));

        Reponse reponse2_1_3 = new Reponse("École","School signifie École");
        this.Cmpt2Serie1.add(new Question("Que veux dire School", reponse2_1_3));

        Reponse reponse2_1_4 = new Reponse("Fenêtre","Window signifie Fenêtre");
        this.Cmpt2Serie1.add(new Question("Que veux dire Window", reponse2_1_4));

        Reponse reponse2_1_5 = new Reponse("Zéro","Zero signifie Zéro");
        this.Cmpt2Serie1.add(new Question("Que veux dire Zero", reponse2_1_5));

        Reponse reponse2_1_6 = new Reponse("Sac à dos","Backpack signifie Sac à dos");
        this.Cmpt2Serie1.add(new Question("Que veux dire Backpack", reponse2_1_6));

        Reponse reponse2_1_7 = new Reponse("Poule","Chicken signifie Poule");
        this.Cmpt2Serie1.add(new Question("Que veux dire Chicken", reponse2_1_7));

        Reponse reponse2_1_8 = new Reponse("Chaussure","Shoe signifie Chaussure");
        this.Cmpt2Serie1.add(new Question("Que veux dire Shoe", reponse2_1_8));

        Reponse reponse2_1_9 = new Reponse("Feuilles","Leaf signifie Feuilles");
        this.Cmpt2Serie1.add(new Question("Que veux dire Leaf", reponse2_1_9));

        Reponse reponse2_1_10 = new Reponse("Main","'Hand' signifie 'Main'.");
        this.Cmpt2Serie1.add(new Question("Que veux dire Hand?", reponse2_1_10));

        Reponse reponse2_2_1 = new Reponse("Je ne pense pas","'I don't think so' signifie 'Je ne sais pas'.");
        this.Cmpt2Serie2.add(new Question("Que veux dire 'I don't think so'?", reponse2_2_1));

        Reponse reponse2_2_2 = new Reponse("Attends une minute","'Wait a minute?' signifie 'Attends une minute'.");
        this.Cmpt2Serie2.add(new Question("Que veux dire 'Wait  a minute'?", reponse2_2_2));

        Reponse reponse2_2_3 = new Reponse("Excusez moi","'I apologise' signifie 'Excusez moi'.");
        this.Cmpt2Serie2.add(new Question("Que veux dire 'I apologise'?", reponse2_2_3));

        Reponse reponse2_2_4 = new Reponse("Je suis malade","'I am sick' signifie 'Je suis malade'.");
        this.Cmpt2Serie2.add(new Question("Que veux dire 'I am sick'?", reponse2_2_4));

        Reponse reponse2_2_5 = new Reponse("Ne t'en fais pas","'Don't worry' signifie 'Ne t'en fais pas'.");
        this.Cmpt2Serie2.add(new Question("Que veux dire 'Don't worry'?", reponse2_2_5));

        Reponse reponse2_2_6 = new Reponse("Au fait","'By the way' signifie 'Au fait'.");
        this.Cmpt2Serie2.add(new Question("Que veux dire 'By the way'?", reponse2_2_6));

        Reponse reponse2_2_7 = new Reponse("Amuses toi bien","'Have fun' signifie 'Amuses toi bien'.");
        this.Cmpt2Serie2.add(new Question("Que veux dire 'Have fun'?", reponse2_2_7));

        Reponse reponse2_2_8 = new Reponse("Tu me manques","'I miss you' signifie 'Tu me manques'.");
        this.Cmpt2Serie2.add(new Question("Que veux dire 'I miss you'?", reponse2_2_8));

        Reponse reponse2_2_9 = new Reponse("Pouvez vous répeter?","'Can you repeat please?' signifie 'Pouvez répeter?'.");
        this.Cmpt2Serie2.add(new Question("Que veux dire 'Can you repeat please?'?", reponse2_2_9));

        Reponse reponse2_2_10 = new Reponse("Allons y","'Let's go' signifie 'Allons y'.");
        this.Cmpt2Serie2.add(new Question("Que veux dire 'Let's go'", reponse2_2_10));

        Reponse reponse2_3_1 = new Reponse("I don't think so","'I don't think so' signifie 'Je ne sais pas'.");
        this.Cmpt2Serie3.add(new Question("Comment dire 'Je ne pense pas'?", reponse2_3_1));

        Reponse reponse2_3_2 = new Reponse("Wait a minute","'Wait a minute' signifie 'Attends une minute'.");
        this.Cmpt2Serie3.add(new Question("Comment dire 'Attends une minute'?", reponse2_3_2));

        Reponse reponse2_3_3 = new Reponse("I apologise","'I apologise' signifie 'Excusez moi'.");
        this.Cmpt2Serie3.add(new Question("Comment dire 'Excusez moi'?", reponse2_3_3));

        Reponse reponse2_3_4 = new Reponse("I am sick","'I am sick' signifie 'Je suis malade'.");
        this.Cmpt2Serie3.add(new Question("Comment dire 'Je suis malade'?", reponse2_3_4));

        Reponse reponse2_3_5 = new Reponse("Don't worry","'Don't worry' signifie 'Ne t'en fais pas'.");
        this.Cmpt2Serie3.add(new Question("Comment dire 'Ne t'en fais pas'?", reponse2_3_5));

        Reponse reponse2_3_6 = new Reponse("By the way","'By the way' signifie 'Au fait'.");
        this.Cmpt2Serie3.add(new Question("Comment dire 'Au fait'?", reponse2_3_6));

        Reponse reponse2_3_7 = new Reponse("Have fun","'Have fun' signifie 'Amuses toi bien'.");
        this.Cmpt2Serie3.add(new Question("Comment dire 'Amuses toi bien'?", reponse2_3_7));

        Reponse reponse2_3_8 = new Reponse("I miss you","'I miss you' signifie 'Tu me manques'.");
        this.Cmpt2Serie3.add(new Question("Comment dire 'Tu me manques'?", reponse2_3_8));

        Reponse reponse2_3_9 = new Reponse("Can you repeat please?","'Can you repeat please?' signifie 'Pouvez répeter?'.");
        this.Cmpt2Serie3.add(new Question("Comment dire 'Pouvez vous répeter?'?", reponse2_3_9));

        Reponse reponse2_3_10 = new Reponse("Let's go","'Let's go' signifie 'Allons y'.");
        this.Cmpt2Serie3.add(new Question("Comment dire 'Allons y'", reponse2_3_10));*/
    }



    public static GestionnaireQuestion getInstance(){
        return gestionnaireQuestion;
    }

    public ArrayList<Question> getSerieQuestion(String cmpt, String serie){
        if(cmpt.equals("competence1")){
            switch (serie){
                case "facile":
                    return this.Cmpt1Serie1;
                case "moyen":
                    return  this.Cmpt1Serie2;
                case "difficile":
                    return  this.Cmpt1Serie3;
                default:
                    return new ArrayList<Question>();
            }
        }
        else if(cmpt.equals("competence2")){
            /*switch (serie){
                case "serie1":
                    return this.Cmpt2Serie1;
                case "serie2":
                    return  this.Cmpt2Serie2;
                case "serie3":
                    return  this.Cmpt2Serie3;
                default:
                    return new ArrayList<Question>();
            }*/
            return new ArrayList<Question>();
        }
        else{
            return new ArrayList<Question>();
        }
    }

    public HashMap<Question, Reponse> getErreurs(){
        return this.erreurs;
    }

    public void addErreurs(Question q, Reponse r){
        this.erreurs.put(q,r);
    }

    public void resetErreurs(){
        this.erreurs=new HashMap<Question, Reponse>();
    }
}
