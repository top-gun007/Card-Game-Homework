package card_pack;

/**
 * Created by ashu on 19/4/18.
 */

public class CardDeck {
    public static final int NCARDS = 52;

    private Cards[] deckOfCards;         // Contains all 52 cards
    private int currentCard;            // deal THIS card in deck

    public CardDeck( )
    {
        deckOfCards = new Cards[NCARDS];

        int i = 0;

        for ( int suit = Cards.DIAMOND; suit <= Cards.SPADE; suit++ )
            for ( int rank = 1; rank <= 13; rank++ )
                deckOfCards[i++] = new Cards(suit, rank);

        currentCard = 0;
    }

    public void shuffle(int n)
    {
        int i, j, k;

        for ( k = 0; k < n; k++ )
        {
            i = (int) ( NCARDS * Math.random() );
            j = (int) ( NCARDS * Math.random() );

            Cards tmp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[j];
            deckOfCards[j] = tmp;
        }

        currentCard = 0;
    }

    public Cards deal()
    {
        if ( currentCard < NCARDS )
        {
            return ( deckOfCards[ currentCard++ ] );
        }
        else
        {
            System.out.println("Out of cards error");
            return ( null );
        }
    }

    public String toString()
    {
        String s = "";
        int k;

        k = 0;
        for ( int i = 0; i < 4; i++ )
        {
            for ( int j = 1; j <= 13; j++ )
                s += (deckOfCards[k++] + " ");

            s += "\n";
        }
        return ( s );
    }
}
